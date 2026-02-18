package school.sorokin.javacore.ReflectionAPI.AnnotationTask;

public class Service {

    @Action(description = "Запуск сервиса")
    public void start() {
        System.out.println("Service started!");
    }

    public void stop() {
        System.out.println("Service stopped");
    }

    public void restart() {
        System.out.println("Service restarted");
    }

    @Action(description = "Проверка статуса сервиса")
    public void checkStatus() {
        System.out.println("Service status: OK");
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
