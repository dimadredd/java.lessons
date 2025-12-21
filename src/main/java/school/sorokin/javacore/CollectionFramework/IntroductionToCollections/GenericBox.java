package school.sorokin.javacore.CollectionFramework.IntroductionToCollections;

public class GenericBox<T> {

    private T content;

    public GenericBox(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isEqual(GenericBox<T> other){
        return this.content.equals(other.getContent());
    }

    public void swap(GenericBox<T> other){
        T temp = this.content;
        this.content = other.content;
        other.content = temp;
    }
}
