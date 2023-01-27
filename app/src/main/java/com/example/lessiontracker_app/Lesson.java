package com.example.lessiontracker_app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Lesson {
        private int sabak;
        private int sabki;
        private int manzil;
        private String date;
        private int s_id;
        private DateFormat dateFormat;

        public Lesson(String date,int sabki,int sabak,int manzil,int s_id) {
            this.sabak = sabak;
            this.sabki = sabki;
            this.manzil = manzil;
            if(date.contentEquals("")) {
                Date today = Calendar.getInstance().getTime();
                this.dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                this.date = this.dateFormat.format(today);
            }
            else{this.date = date;}

            this.s_id = s_id;
        }

        public int getSabak() {
            return this.sabak;
        }
        public void setSabak(int sabak) {
            this.sabak = sabak;
        }

        public void setSabki(int sabki) {
            this.sabki = sabki;
        }

        public int getSabki() {
            return this.sabki;
        }

        public void setManzil(int manzil) {
            this.manzil = manzil;
        }

        public int getSid() {
            return this.s_id;
        }


        public void setSid(int id) {
            this.s_id = id;
        }

        public int getManzil() {
            return this.manzil;
        }


        public String getDate() {
            return this.date;
        }

        public void setDate(String date) {
            this.date = date;
        }


        @Override
        public String toString() {
            return "Lesson";
        }
}
