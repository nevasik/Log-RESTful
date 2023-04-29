//package com.example.demo.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "Logs")
//public class Log2 {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "message")
//    @NotEmpty(message = "message cannot be empty")
//    private String message;
//
//    @Column(name = "type")
//    @NotEmpty(message = "type cannot be empty")
//    private String type;
//
//    @Column(name = "level")
//    @NotEmpty(message = "level cannot be empty")
//    private String level;
//
//    @Column(name = "timestamp")
////    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime time;
//
//    public Log2() {
//    }
//
//    public Log2(String message, String type, String level, LocalDateTime time) {
//        this.message = message;
//        this.type = type;
//        this.level = level;
//        this.time = time;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    public LocalDateTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalDateTime time) {
//        this.time = time;
//    }
//
//    @Override
//    public String toString() {
//        return "Log2{" +
//                "id=" + id +
//                ", message='" + message + '\'' +
//                ", type='" + type + '\'' +
//                ", level='" + level + '\'' +
//                ", time=" + time +
//                '}';
//    }
//}