package p5;

public interface PropertyObserver<V> {
void propertyChanged(ObservableProperty<V> property, V oldValue);
}