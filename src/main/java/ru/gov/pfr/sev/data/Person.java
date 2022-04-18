package ru.gov.pfr.sev.data;

import org.joda.time.LocalDate;

import javax.xml.crypto.Data;

public class Person {
    private Integer id;
    private String fa;
    private String im;
    private String ot;
    private LocalDate dr;
    private String addr;
    private String vidDoc;
    private String serNumDoc;
    private LocalDate dateVydachi;
    private String kemVydan;

    public Person() {
    }

    public Person(String fa, String im, String ot, String vidDoc, String serNumDoc, String kemVydan) {
        this.fa = fa;
        this.im = im;
        this.ot = ot;
        this.vidDoc = vidDoc;
        this.serNumDoc = serNumDoc;
        this.kemVydan = kemVydan;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setVidDoc(String vidDoc) {
        this.vidDoc = vidDoc;
    }

    public void setSerNumDoc(String serNumDoc) {
        this.serNumDoc = serNumDoc;
    }

    public void setKemVydan(String kemVydan) {
        this.kemVydan = kemVydan;
    }

    public Integer getId() {
        return id;
    }

    public String getFa() {
        return fa;
    }

    public String getIm() {
        return im;
    }

    public String getOt() {
        return ot;
    }

    public String getVidDoc() {
        return vidDoc;
    }

    public String getSerNumDoc() {
        return serNumDoc;
    }

    public String getKemVydan() {
        return kemVydan;
    }

    public LocalDate getDr() {
        return dr;
    }

    public void setDr(LocalDate dr) {
        this.dr = dr;
    }

    public LocalDate getDateVydachi() {
        return dateVydachi;
    }

    public void setDateVydachi(LocalDate dateVydachi) {
        this.dateVydachi = dateVydachi;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fa='" + fa + '\'' +
                ", im='" + im + '\'' +
                ", ot='" + ot + '\'' +
                ", dr=" + dr +
                ", addr='" + addr + '\'' +
                ", vidDoc='" + vidDoc + '\'' +
                ", serNumDoc='" + serNumDoc + '\'' +
                ", dateVydachi=" + dateVydachi +
                ", kemVydan='" + kemVydan + '\'' +
                '}';
    }
}
