package school.sorokin.javacore.ReflectionAPI.IntroductionToReflection;

import java.time.LocalDate;

public class Member {
    private String status;
    private LocalDate date;
    private long id;

    public Member(String status, LocalDate date, long id) {
        this.status = status;
        this.date = date;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getId() {
        return id;
    }
}
