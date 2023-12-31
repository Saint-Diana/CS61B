public class NBody {

    /**
     * Read radius from file
     * 
     * @param filePath the path of the file you give
     * @return return a double describing the radius
     */
    public static double readRadius(String filePath) {
        In in = new In(filePath);
        in.readInt();
        return in.readDouble();
    }

    /**
     * Read planets from file
     * 
     * @param filePath the path of the file you give
     * @return return an array of Planets corresponding to the planets in the file
     */
    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int n = in.readInt();
        Planet[] planets = new Planet[n];
        in.readDouble();
        for (int i = 0; i < n; ++i) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // set the universe scale
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t <= T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; ++i) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; ++i) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            /* draw the backgroud picture */
            StdDraw.picture(0, 0, "images/starfield.jpg");

            /* draw all planets */
            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            /* pause 10 ms */
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
