package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox jb = new Jukebox();
        int position = args.length == 0 ? 1 : Integer.parseInt(args[0]);
        jb.music(position);
    }

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

}
