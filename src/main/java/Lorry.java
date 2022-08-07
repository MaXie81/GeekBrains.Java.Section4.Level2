class Lorry extends Car implements Moveable, Stopable {   //в Java нет множественного наследования
    public void move(){
        System.out.println("Car is moving");
    }
    public void stop(){
        System.out.println("Car is stop");
    }

    @Override
    void open() {   //абстрактный метод должен быть реализован в классе-наследнике
        System.out.println("Car is open");
    }
}
