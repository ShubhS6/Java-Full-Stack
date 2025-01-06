package com.hibernateOneToMany.hibernateOneToMany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class instructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;
    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    private instructor instructor;

    public instructorDetail() {
    }

    public instructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public com.hibernateOneToMany.hibernateOneToMany.model.instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(com.hibernateOneToMany.hibernateOneToMany.model.instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "instructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
