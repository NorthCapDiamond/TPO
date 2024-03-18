package com.dmitrydrobysh.app;

/**
 * Они сидели на мостовой и смотрели с некоторым беспокойством, 
 * как огромные дети тяжело прыгают по песку, а дикие лошади 
 * с грохотом везут по небу в Неизведанные Области 
 * свежие запасы армированных изгородей.
 */

public class App{
    public static void main( String[] args ){
        Watcher dima = new Watcher("Dima", 3);
        Watcher vanya = new Watcher("Vanya", 1);

        Kid maxim = new Kid("Maxim", true);
        Kid vovan = new Kid("Vovan", false);
        Kid gleb = new Kid("Gleb", false);


        dima.watchFor(maxim.doAction(), maxim.isNormal());
        vanya.watchFor(maxim.doAction(), maxim.isNormal());

        dima.watchFor(vovan.doAction(), vovan.isNormal());
        vanya.watchFor(vovan.doAction(), vovan.isNormal());

        dima.watchFor(gleb.doAction(), gleb.isNormal());
        vanya.watchFor(gleb.doAction(), gleb.isNormal());



        Horse biba = new Horse("Biba", false);
        Horse boba = new Horse("Boba", false);
        Horse kordoba = new Horse("Boba", true);


        dima.watchFor(biba.doAction(), biba.isNormal());
        vanya.watchFor(biba.doAction(), biba.isNormal());

        dima.watchFor(boba.doAction(), boba.isNormal());
        vanya.watchFor(boba.doAction(), boba.isNormal());

        dima.watchFor(kordoba.doAction(), kordoba.isNormal());
        vanya.watchFor(kordoba.doAction(), kordoba.isNormal());


    }
}
