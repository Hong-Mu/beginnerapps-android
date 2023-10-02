package com.hongmu.d_day

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongmu.d_day.databinding.ActivityMainBinding
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var start: Long = 0
        var end: Long = 0
        binding.btnStartDate.setOnClickListener {
            val calendar = GregorianCalendar()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val date = calendar.get(Calendar.DATE)
            val dialog = DatePickerDialog(this, { datePicker, _year, _month, _day ->
                start = LocalDate.of(_year, _month + 1, _day).atTime(0, 0).atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli()
                binding.textCounter.text = getDateMillis(end - start).toString()
            }, year, month, date)
            dialog.show()
        }

        binding.btnEndDate.setOnClickListener {
            val calendar = GregorianCalendar()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val date = calendar.get(Calendar.DATE)
            val dialog = DatePickerDialog(this, { datePicker, _year, _month, _day ->
                end = LocalDate.of(_year, _month + 1, _day).atTime(0, 0).atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli()
                binding.textCounter.text = getDateMillis(end - start).toString()
            }, year, month, date)
            dialog.show()
        }

    }

    private fun getDateMillis(diff: Long): Long {
        return TimeUnit.MILLISECONDS.toDays(diff)
    }
}