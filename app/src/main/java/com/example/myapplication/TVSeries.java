package com.example.myapplication;

public class TVSeries {
    String tvseriesName,tvseriesDesc,tvseriesGenre,tvseriesDuration,tvseriesProducer,tvseriesYear;
    int tvseriesCoverPhoto;

    public TVSeries(String tvseriesName, String tvseriesDesc, String tvseriesGenre, String tvseriesDuration, String tvseriesProducer, String tvseriesYear, int tvseriesCoverPhoto) {
        this.tvseriesName = tvseriesName;
        this.tvseriesDesc = tvseriesDesc;
        this.tvseriesGenre = tvseriesGenre;
        this.tvseriesDuration = tvseriesDuration;
        this.tvseriesProducer = tvseriesProducer;
        this.tvseriesYear = tvseriesYear;
        this.tvseriesCoverPhoto = tvseriesCoverPhoto;
    }

    public String getTvseriesName() {
        return tvseriesName;
    }

    public String getTvseriesDesc() {
        return tvseriesDesc;
    }

    public String getTvseriesGenre() {
        return tvseriesGenre;
    }

    public String getTvseriesDuration() {
        return tvseriesDuration;
    }

    public String getTvseriesProducer() {
        return tvseriesProducer;
    }

    public String getTvseriesYear() {
        return tvseriesYear;
    }

    public int getTvseriesCoverPhoto() {
        return tvseriesCoverPhoto;
    }
}
