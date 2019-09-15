package ru.job4j.pojo;

public class Library
{
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean code", 500);
        books[1] = new Book("War and Peace", 600);
        books[2] = new Book("Capital", 1000);
        books[3] = new Book("NoName", 100);

        for(Book b : books){
            System.out.println(b);
        }

        Book book = books[0];
        books[0] = books[3];
        books[3] = book;

        for(Book b : books){
            System.out.println(b);
        }

        for(Book b : books){
            if(b.getName().equals("Clean code")){
                System.out.println(b);
            }
        }
    }
}
