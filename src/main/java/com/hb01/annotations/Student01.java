package com.hb01.annotations;

import javax.persistence.*;

@Entity  //!!! @Entity koyduğumuz sınıf, veritabanında bir tabloya karşılık gelecek
@Table(name = "t_student01") //!!! Eğer oluşacak tablo ismini değiştirmek istenirse name attribute ile
// bir tablo ismi verilir.
//!!! @Table ile isim değiştirilmese idi, DB de (küçük harfle) student01 isminde tablo oluşacaktı
public class Student01 { // student01

    @Id//!!! @Id --> primary key oluşmasını sağlıyor.
    //@Column(name = "std_id")
    private int id;

    //!!! Column annotationı zorunlu değil ancak customize edebilmek için  gerekli
    @Column(name = "student_name", length = 100, nullable = false, unique = false)
    //!!! Javaca konusurken name , SQL ce konusacaksam student_name kullanmam lazim
    private String name; // 255 karakter

    //!!! @Transient --> veritabanı tablosunda "grade" adında bir kolon oluşturulmaz. kod içinde
    // kullanılmak için bir değişken oluştururuz ama bu sınıf DB ye kaydedileceği
    // zaman ilgili tabloya kolon olarak eklenmez
    //@Transient
    private int grade;

}