package com.hongmu.diet

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hongmu.diet.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database = Firebase.database
        val ref = database.getReference("memo").child(Firebase.auth.currentUser!!.uid)

        val memoAdapter = MemoAdapter(listOf())
        binding.listView.adapter = memoAdapter

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(model in snapshot.children) {

                }
                memoAdapter.list = snapshot.children.map {
                    it.getValue(MemoModel::class.java)!!
                }.toList()
                memoAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })



        binding.btnWrite.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_main, null)
            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("운동 메모 다이얼로그")
                .show()

            val inputMemo = dialog.findViewById<EditText>(R.id.input_memo)

            var dateText = ""
            dialog.findViewById<Button>(R.id.btn_select)?.setOnClickListener {
                val calendar = GregorianCalendar()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val date = calendar.get(Calendar.DATE)
                val datePickerDialog = DatePickerDialog(this, { datePicker, _year, _month, _date ->
                    dateText = "$_year ${_month + 1} $_date"
                    (it as Button).text = dateText
                }, year, month, date)
                datePickerDialog.show()
            }

            dialog.findViewById<Button>(R.id.btn_save)?.setOnClickListener {
                val inputText = inputMemo?.text.toString()
                val model = MemoModel(dateText, inputText)


                ref.push().setValue(model)

                dialog.dismiss()
            }
        }
    }

    data class MemoModel(
        val date: String = "",
        val memo: String = "",
    )
}