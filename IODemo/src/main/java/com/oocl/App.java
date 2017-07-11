package com.oocl;

import com.oocl.avata.Avatar;
import com.oocl.avata.Human;
import com.oocl.avata.Intelligor;
import com.oocl.avata.Monkey;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Intelligor man = new Human();
        Intelligor avatar = new Avatar(man);
        Intelligor monkey = new Monkey();
        avatar.run();
    }
}
