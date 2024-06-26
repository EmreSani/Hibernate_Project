package com.hb07.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

    @Id
    private int id; // String , Integer

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //!!! Trick :Cascade.Remove ve OrphanRemoval arasındaki fark :   CascadeType.REMOVE varsa,
     //  eğer parent(Student) nesne silinirse, child/dependent(Book) nesne de silinir.
    //  Ancak bu seçenek child(Book) nesneye null değeri atarsak veya başka bir child
    //  nesne ile değiştirirsek devreye girmez, OrphanRemoval daha agresif davranir, child nesnesini gosteren
    //  degiskeni null yaparsaniz, gider child nesnesini de siler bunu GarbageCollector da yapiyor aslinda
    //!!! OrphanRemoval veya CascadeType.REMOVE nerede kullanilir? Musteri var ve musterinin ileriye donuk 10
     // tane siparisi var, musteri silinirse siparisleride silinsin isterim
    //!!! nerede kullanilmaz ?  Ogrenciyi sildigimde ogrencinin aldigi butun derslerde DB den silinr ve bu
     // istenmeyen bir durumdur
    private List<Book07> bookList = new ArrayList<>();

    //!!! Getter - Setter ****************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    //!!! toString() ***********************************************8

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
