package com.clicsixdev.holidays2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    List<Holiday> holidayList;

    RecyclerView recyclerView;

    MyDbHandler dbHandler;

    HolidayAdapter adapter;

    String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource(this,R.array.months_array,R.layout.spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(monAdapter);
        spinner.setOnItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        dbHandler = new MyDbHandler(this);

        if(dbHandler.getRows() == 0){

            dbHandler.addHoliday("New Year's Day","2018-01-01","Arunachal Pradesh, Meghalaya, Manipur, Mizoram, Nagaland, Rajasthan, Sikkim & Tamil Nadu");
            dbHandler.addHoliday("New Year Holiday","2018-01-02","Mizoram");
            dbHandler.addHoliday("Missionary Day","2018-01-11","Mizoram");
            dbHandler.addHoliday("Swami Vivekananda Jayanti","2018-01-12","West Bengal");
            dbHandler.addHoliday("Makara Sankranti","2018-01-14","Gujarat, Sikkim & Telangana");
            dbHandler.addHoliday("Pongal","2018-01-14","Andhra Pradesh, Arunachal Pradesh, Puducherry & Tamil Nadu");
            dbHandler.addHoliday("Makara Sankranti","2018-01-15","Karnataka");
            dbHandler.addHoliday("Thiruvalluvar Day","2018-01-15","Tamil Nadu");
            dbHandler.addHoliday("Kanuma Panduga","2018-01-15","Andhra Pradesh");
            dbHandler.addHoliday("Magh Bihu","2018-01-15","Assam");
            dbHandler.addHoliday("Uzhavar Thirunal","2018-01-16","Puducherry & Tamil Nadu");
            dbHandler.addHoliday("Sonam Losar","2018-01-18","Sikkim");
            dbHandler.addHoliday("Vasant Panchami","2018-01-22","Haryana, Orissa, Punjab, Tripura & West Bengal");
            dbHandler.addHoliday("Netaji Subhas Chandra Bose Jayanti","2018-01-23","Orissa, Tripura & West Bengal");
            dbHandler.addHoliday("Sir Chhotu Ram Jayanti","2018-01-24","Haryana");
            dbHandler.addHoliday("State Day","2018-01-25","Himachal Pradesh");
            dbHandler.addHoliday("Republic Day","2018-01-26","National");
            dbHandler.addHoliday("Me-Dum-Me-Phi","2018-01-31","Assam");
            dbHandler.addHoliday("Guru Ravidas Jayanti","2018-01-31","Chandigarh, Himachal Pradesh, Haryana & Punjab");
            dbHandler.addHoliday("Maharshi Dayanand Sarswati Jayanti","2018-02-10","Haryana");
            dbHandler.addHoliday("Maha Shivaratri","2018-02-13","National except Andaman and Nicobar, Arunachal Pradesh, Assam, Bihar, Dadra and Nagar Haveli, Goa, Lakshadweep, Madhya Pradesh, Manipur, Meghalaya, Mizoram, Nagaland, Puducherry, Sikkim, Tamil Nadu & West Bengal");
            dbHandler.addHoliday("Lui-Ngai-Ni","2018-02-15","Manipur");
            dbHandler.addHoliday("Losar","2018-02-16","Sikkim");
            dbHandler.addHoliday("Chhatrapati Shivaji Maharaj Jayanti","2018-02-19","Maharastra");
            dbHandler.addHoliday("State Day","2018-02-20","Arunachal Pradesh & Mizoram");
            dbHandler.addHoliday("Holi","2018-03-01","Andhra Pradesh, Assam, Jammu & Kashmir, Manipur, Uttarakhand, Uttar Pradesh & West Bengal");
            dbHandler.addHoliday("Holi","2018-03-02","National except Andhra Pradesh, Assam, Jammu & Kashmir, Karnataka, Kerala, Lakshadweep, Manipur, Puducherry, Tamil Nadu, Uttar Pradesh, Uttarakhand & West Bengal");
            dbHandler.addHoliday("Panchayatiraj Divas","2018-03-05","Orissa");
            dbHandler.addHoliday("Ugadi","2018-03-18","Andhra Pradesh, Goa, Gujarat, Jammu & Kashmir, Karnataka, Maharastra, Rajasthan & Telangana");
            dbHandler.addHoliday("Telugu New Year","2018-03-18","Tamil Nadu");
            dbHandler.addHoliday("Sajibu Nongmapanba (Cheiraoba)","2018-03-18","Manipur");
            dbHandler.addHoliday("Sarhul","2018-03-20","Jharkhand");
            dbHandler.addHoliday("Bihar Day","2018-03-22","Bihar");
            dbHandler.addHoliday("S. Bhagat Singh's Martyrdom Day","2018-03-23","Haryana & Punjab");
            dbHandler.addHoliday("Ram Navami","2018-03-25","National except Arunachal Pradesh, Assam, Dadra and Nagar Haveli, Goa, Jammu & Kashmir, Karnataka, Kerala, Lakshadweep, Manipur, Meghalaya, Mizoram, Nagaland, Puducherry, Tamil Nadu, Tripura & West Bengal");
            dbHandler.addHoliday("Mahavir Jayanti","2018-03-29","Arunachal Pradesh, Chhattisgarh, Delhi, Dadra and Nagar Haveli, Gujarat, Haryana, Karnataka, Lakshadweep, Maharastra, Madhya Pradesh, Mizoram, Punjab, Rajasthan, Tamil Nadu & Uttar Pradesh");
            dbHandler.addHoliday("Good Friday","2018-03-30","National except Haryana & Jammu & Kashmir");
            dbHandler.addHoliday("Hazrat Ali Jayanti","2018-03-31","Uttar Pradesh");
            dbHandler.addHoliday("Easter Saturday","2018-03-31","Nagaland");
            dbHandler.addHoliday("Odisha Day","2018-04-01","Orissa");
            dbHandler.addHoliday("Easter Sunday","2018-04-01","Kerala & Nagaland");
            dbHandler.addHoliday("Babu Jagjivan Ram Jayanti","2018-04-05","Andhra Pradesh & Telangana");
            dbHandler.addHoliday("Bohag Bihu Holiday","2018-04-13","Assam");
            dbHandler.addHoliday("Vaisakh","2018-04-14","Chandigarh, Haryana, Jammu & Kashmir & Punjab");
            dbHandler.addHoliday("Dr Ambedkar Jayanti","2018-04-14","National except Andaman and Nicobar, Arunachal Pradesh, Assam, Chandigarh, Dadra and Nagar Haveli, Daman and Diu, Delhi, Lakshadweep, Manipur, Meghalaya, Mizoram, Nagaland & Tripura");
            dbHandler.addHoliday("Tamil New Year","2018-04-14","Puducherry & Tamil Nadu");
            dbHandler.addHoliday("Bohag Bihu","2018-04-14","Assam");
            dbHandler.addHoliday("Maha Vishuba Sankranti","2018-04-14","Orissa");
            dbHandler.addHoliday("Cheiraoba","2018-04-14","Manipur");
            dbHandler.addHoliday("Bengali New Year","2018-04-15","Tripura & West Bengal");
            dbHandler.addHoliday("Himachal Day","2018-04-15","Himachal Pradesh");
            dbHandler.addHoliday("Vishu","2018-04-15","Kerala");
            dbHandler.addHoliday("Maharshi Parasuram Jayanti","2018-04-18","Gujarat, Himachal Pradesh, Haryana, Madhya Pradesh & Punjab");
            dbHandler.addHoliday("Basava Jayanti","2018-04-18","Karnataka");
            dbHandler.addHoliday("Buddha Purnima","2018-04-30","Andaman and Nicobar, Arunachal Pradesh, Chhattisgarh, Chandigarh, Delhi, Himachal Pradesh, Haryana, Jharkhand, Jammu & Kashmir, Maharastra, Madhya Pradesh, Mizoram, Tripura, Uttarakhand, Uttar Pradesh & West Bengal");
            dbHandler.addHoliday("May Day","2018-05-01","Assam, Bihar, Goa, Karnataka, Kerala, Manipur, Punjab, Puducherry, Telangana, Tamil Nadu, Tripura & West Bengal");
            dbHandler.addHoliday("Maharashtra Day","2018-05-01","Maharastra");
            dbHandler.addHoliday("Guru Rabindranath Jayanti","2018-05-07","Tripura & West Bengal");
            dbHandler.addHoliday("State Day","2018-05-16","Sikkim");
            dbHandler.addHoliday("Kazi Nazrul Islam Jayanti","2018-05-25","Tripura");
            dbHandler.addHoliday("Shab-i-Qadr","2018-06-11","Jammu & Kashmir");
            dbHandler.addHoliday("Pahili Raja","2018-06-14","Orissa");
            dbHandler.addHoliday("YMA Day","2018-06-15","Mizoram");
            dbHandler.addHoliday("Raja Sankranti","2018-06-15","Orissa");
            dbHandler.addHoliday("Jumat-ul-Wida","2018-06-15","Jammu & Kashmir");
            dbHandler.addHoliday("Idul Fitr","2018-06-15","National");
            dbHandler.addHoliday("Maharana Pratap Jayanti","2018-06-16","Himachal Pradesh, Haryana & Rajasthan");
            dbHandler.addHoliday("Idul Fitr Holiday","2018-06-16","Telangana");
            dbHandler.addHoliday("Sri Guru Arjun Dev Ji's Martyrdom Day","2018-06-17","Punjab");
            dbHandler.addHoliday("Sant Guru Kabir Jayanti","2018-06-28","Chhattisgarh, Himachal Pradesh, Haryana & Punjab");
            dbHandler.addHoliday("Remna Ni","2018-06-30","Mizoram");
            dbHandler.addHoliday("MaharastraIP Day","2018-07-06","Mizoram");
            dbHandler.addHoliday("Martyrs' Day","2018-07-13","Jammu & Kashmir");
            dbHandler.addHoliday("Ratha Yathra","2018-07-14","Manipur & Orissa");
            dbHandler.addHoliday("Kharchi Puja","2018-07-20","Tripura");
            dbHandler.addHoliday("Shaheed Udham Singh's Martyrdom Day","2018-07-31","Punjab");
            dbHandler.addHoliday("Bonalu","2018-08-01","Telangana");
            dbHandler.addHoliday("Ker Puja","2018-08-03","Tripura");
            dbHandler.addHoliday("Patriots Day","2018-08-13","Manipur");
            dbHandler.addHoliday("Haryali Teej","2018-08-14","Haryana");
            dbHandler.addHoliday("Independence Day","2018-08-15","National");
            dbHandler.addHoliday("De Jure Transfer Day","2018-08-16","Puducherry");
            dbHandler.addHoliday("Parsi New Year","2018-08-17","Gujarat & Maharastra");
            dbHandler.addHoliday("Bakrid / Eid al Adha","2018-08-22","National except Daman and Diu, Puducherry & Sikkim");
            dbHandler.addHoliday("Bakrid / Eid al Adha Holiday","2018-08-23","Jammu & Kashmir");
            dbHandler.addHoliday("First Onam","2018-08-24","Kerala");
            dbHandler.addHoliday("Thiruvonam","2018-08-25","Kerala");
            dbHandler.addHoliday("Raksha Bandhan","2018-08-26","Chhattisgarh, Daman and Diu, Gujarat, Madhya Pradesh, Rajasthan, Uttarakhand & Uttar Pradesh");
            dbHandler.addHoliday("Jhulan Purnima","2018-08-26","Orissa");
            dbHandler.addHoliday("Sree Narayana Guru Jayanti","2018-08-27","Kerala");
            dbHandler.addHoliday("Janmashtami","2018-09-03","National except Arunachal Pradesh, Assam, Chandigarh, Dadra and Nagar Haveli, Goa, Karnataka, Kerala, Lakshadweep, Maharastra, Meghalaya, Mizoram, Puducherry & West Bengal");
            dbHandler.addHoliday("Parkash Utsav Sri Guru Granth Sahib Ji","2018-09-03","Punjab");
            dbHandler.addHoliday("Ganesh Chaturthi","2018-09-13","Andhra Pradesh, Daman and Diu, Dadra and Nagar Haveli, Goa, Gujarat, Karnataka, Maharastra, Orissa, Puducherry, Telangana & Tamil Nadu");
            dbHandler.addHoliday("Nuakhai","2018-09-14","Orissa");
            dbHandler.addHoliday("Ganesh Chaturthi Holiday","2018-09-14","Goa");
            dbHandler.addHoliday("Baba Sri Chand Ji Jayanti","2018-09-18","Punjab");
            dbHandler.addHoliday("Ramdev Jayanti","2018-09-19","Rajasthan");
            dbHandler.addHoliday("Teja Dashmi","2018-09-19","Rajasthan");
            dbHandler.addHoliday("Sree Narayana Guru Samadhi","2018-09-21","Kerala");
            dbHandler.addHoliday("Muharram","2018-09-21","National except Arunachal Pradesh, Assam, Daman and Diu, Goa, Jharkhand, Kerala, Manipur, Meghalaya, Nagaland, Puducherry, Punjab, Sikkim, Tripura, Uttarakhand & West Bengal");
            dbHandler.addHoliday("Heroes' Martyrdom Day","2018-09-23","Haryana");
            dbHandler.addHoliday("S. Bhagat Singh Ji Jayanti","2018-09-28","Punjab");
            dbHandler.addHoliday("Gandhi Jayanti","2018-10-02","National");
            dbHandler.addHoliday("Mahalaya Amavasye","2018-10-08","Karnataka, Orissa, Tripura & West Bengal");
            dbHandler.addHoliday("First Day of Bathukamma","2018-10-09","Telangana");
            dbHandler.addHoliday("Ghatasthapana","2018-10-09","Rajasthan");
            dbHandler.addHoliday("Maharaja Agrasen Jayanti","2018-10-10","Haryana & Punjab");
            dbHandler.addHoliday("Maha Saptami","2018-10-16","Orissa, Sikkim, Tripura & West Bengal");
            dbHandler.addHoliday("Maha Ashtami","2018-10-17","Andhra Pradesh, Jharkhand, Manipur, Orissa, Rajasthan, Sikkim, Telangana, Tripura & West Bengal");
            dbHandler.addHoliday("Maha Navami","2018-10-18","Assam, Bihar, Jharkhand, Karnataka, Kerala, Meghalaya, Nagaland, Orissa, Puducherry, Sikkim, Tamil Nadu, Tripura, Uttar Pradesh & West Bengal");
            dbHandler.addHoliday("Vijaya Dashami","2018-10-19","National except Manipur & Puducherry");
            dbHandler.addHoliday("Lakshmi Puja","2018-10-23","Orissa, Tripura & West Bengal");
            dbHandler.addHoliday("Maharishi Valmiki Jayanti","2018-10-24","Chandigarh, Delhi, Himachal Pradesh, Haryana, Karnataka, Madhya Pradesh & Punjab");
            dbHandler.addHoliday("Parkash Gurpurab of Sri Guru Ram Dass Ji","2018-10-26","Punjab");
            dbHandler.addHoliday("Lhabab Duchen","2018-10-30","Sikkim");
            dbHandler.addHoliday("Sardar Vallabhbhai Patel Jayanti","2018-10-31","Gujarat");
            dbHandler.addHoliday("Puducherry Liberation Day","2018-11-01","Puducherry");
            dbHandler.addHoliday("Haryana Day","2018-11-01","Haryana");
            dbHandler.addHoliday("Kannada Rajyothsava","2018-11-01","Karnataka");
            dbHandler.addHoliday("Kut","2018-11-01","Manipur");
            dbHandler.addHoliday("Deepavali","2018-11-06","Andhra Pradesh, Goa, Karnataka, Kerala, Puducherry, Telangana & Tamil Nadu");
            dbHandler.addHoliday("Diwali","2018-11-07","National except Andhra Pradesh, Goa, Karnataka, Kerala, Puducherry, Tamil Nadu & Telangana");
            dbHandler.addHoliday("Vikram Samvat New Year","2018-11-08","Gujarat");
            dbHandler.addHoliday("Deepavali Holiday","2018-11-08","Daman and Diu, Haryana, Karnataka, Maharastra, Meghalaya, Punjab, Rajasthan, Uttarakhand & Uttar Pradesh");
            dbHandler.addHoliday("Bhai Dooj","2018-11-09","Gujarat, Rajasthan, Sikkim, Uttarakhand & Uttar Pradesh");
            dbHandler.addHoliday("Wangala Festival","2018-11-09","Meghalaya");
            dbHandler.addHoliday("Chhath Puja","2018-11-13","Bihar & Jharkhand");
            dbHandler.addHoliday("Chhath Puja Holiday","2018-11-14","Bihar");
            dbHandler.addHoliday("Shahidi Diwas S. Kartar Singh Sarabha Ji","2018-11-16","Punjab");
            dbHandler.addHoliday("Eid e Milad","2018-11-21","National except Andaman and Nicobar, Arunachal Pradesh, Assam, Bihar, Goa, Himachal Pradesh, Manipur, Meghalaya, Punjab, Sikkim & West Bengal");
            dbHandler.addHoliday("Karthika Purnima","2018-11-23","Orissa & Telangana");
            dbHandler.addHoliday("Guru Nanak Jayanti","2018-11-23","National except Andhra Pradesh, Bihar, Daman and Diu, Goa, Karnataka, Kerala, Manipur, Meghalaya, Orissa, Puducherry, Sikkim, Tamil Nadu & Tripura");
            dbHandler.addHoliday("Friday Following Eid e Milad","2018-11-23","Jammu & Kashmir");
            dbHandler.addHoliday("Seng Kut Snem","2018-11-23","Meghalaya");
            dbHandler.addHoliday("Sri Guru Teg Bahadur Ji's Martyrdom Day","2018-11-24","Punjab");
            dbHandler.addHoliday("Kanakadasa Jayanti","2018-11-26","Karnataka");
            dbHandler.addHoliday("Feast of St Francis Xavier","2018-12-03","Goa");
            dbHandler.addHoliday("Sheikh Muhammad Abdullah Jayanti","2018-12-05","Jammu & Kashmir");
            dbHandler.addHoliday("Pa Togan Nengminza Sangma","2018-12-12","Meghalaya");
            dbHandler.addHoliday("Guru Ghasidas Jayanti","2018-12-18","Chhattisgarh");
            dbHandler.addHoliday("Death Anniversary of U SoSo Tham","2018-12-18","Meghalaya");
            dbHandler.addHoliday("Liberation Day","2018-12-19","Daman and Diu & Goa");
            dbHandler.addHoliday("Christmas Day","2018-12-25","National");
            dbHandler.addHoliday("Shaheed Udham Singh Jayanti","2018-12-26","Haryana");
            dbHandler.addHoliday("Christmas Holiday","2018-12-26","Meghalaya & Mizoram");
            dbHandler.addHoliday("Tamu Losar","2018-12-30","Sikkim");
            dbHandler.addHoliday("U Kiang Nangbah","2018-12-30","Meghalaya");
            dbHandler.addHoliday("New Year's Eve","2018-12-31","Manipur");



        }













        holidayList = dbHandler.getHolidays("05");





        adapter = new HolidayAdapter(this, holidayList);
        recyclerView.setAdapter(adapter);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        holidayList = dbHandler.getHolidays(month[position]);
        adapter = new HolidayAdapter(this,holidayList);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
