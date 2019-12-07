package com.abysstone.SongPlayer;

import java.util.*;


public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Cowboys from hell", "Pantera");
        album.addSong("Cowboys from hell", 4.6);
        album.addSong("Primal Concrete Sledge", 4.22);
        album.addSong("Psycho Holiday", 4.3);
        album.addSong("Heresy", 5.6);
        album.addSong("Cemetery Gates", 3.21);
        album.addSong("Domination", 6.23);
        album.addSong("Shattered", 4.27);
        album.addSong("Clash With Reality", 4.2);
        album.addSong("Medicine Man", 3.13);
        album.addSong("Message in Blood", 4.12);
        album.addSong("The Sleep", 3.18);
        album.addSong("The art of shredding", 5.1);

        albums.add(album);

        album = new Album("Badmotorfinger", "Soundgarden");
        album.addSong("Rusty Cage", 5.44);
        album.addSong("Outshined", 3.25);
        album.addSong("Slaves & Bulldozers", 3.45);
        album.addSong("Jesus Christ Pose", 3.33);
        album.addSong("Face Pollution", 4.51);
        album.addSong("Somewhere", 3.45);
        album.addSong("Searching With My Good Eye Closed", 5.25);
        album.addSong("Room A Thousand Years Wide", 5.32);
        album.addSong("Mind Riot", 5.12);
        album.addSong("Drawing Flies", 4.1);
        album.addSong("Holy Water", 3.56);
        album.addSong("New Damage", 5.35);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Primal Concrete Sledge", playList);
        albums.get(0).addToPlayList("Domination", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(29, playList);  // There is no track 29

        play(playList);




    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() >0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }

}
