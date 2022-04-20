package SchoolManegementSystem;

import java.util.concurrent.atomic.AtomicInteger;

abstract class User {
	
    protected String name;
    protected int id;
    
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    
    public User() {
    	this.id = ID_GENERATOR.getAndIncrement();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void print() {
        System.out.println("Kullanıcı Detayı >>>>>> Kullanıcı Adı: " + this.name);
        System.out.println();
    }

    public void print(String message) {
        System.out.println(message +  " Kullanıcı Adı: " + this.name);
    }
}
