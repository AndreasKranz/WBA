package com.example.notendurchschnitt2.security.model;


import com.example.notendurchschnitt2.common.BaseEntity;
import com.example.notendurchschnitt2.Note.model.Note;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "secuser")
public class User extends BaseEntity<Long> {

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;

    //Test die Noten direkt im User zu speichern
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> notenListe;

    public User(){
        this.notenListe = new ArrayList<>();
    }


    public Long getId() {
        return super.getId();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //Test die Notenliste im User zu speichern
    public List<Note> getNotenListe() {
        return notenListe;
    }

    public void setNotenListe(List<Note> notenListe) {
        this.notenListe = notenListe;
    }

    public void addNote(Note note){
        this.notenListe.add(note);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                "nicknameo=" + nickname +
                ", email='" + email.replaceFirst("@.*", "@***") +
                ", password='" + password.substring(0, 10) +
                ", role=" + role +
                '}';
    }
}
