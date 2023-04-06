package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    //plan is to save this card in db

    //before saving set all its attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;  //Auto generated

    @CreationTimestamp
    Date createdOn;  //auto generated

    @UpdateTimestamp
    Date updatedOn;  //auto generated

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    public Card() {
    }

    @OneToOne
    @JoinColumn
    private Student studentVariableName;//this variable is used in the parent class while doing bidirectional mapping

    //many books can be issued to one card
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
