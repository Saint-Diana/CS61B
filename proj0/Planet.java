/**
 * @author Huichang Shen
 * @date 2023-12-31
 */
public class Planet {
    /* Constant: G */
    public static double G = 6.67E-11;

    /* its current x position */
    public double xxPos;

    /* its current y position */
    public double yyPos;

    /* its current velocity in the x direction */
    public double xxVel;

    /* its current velocity in the y direction */
    public double yyVel;

    /* its mass */
    public double mass;

    /* the name of the file that corresponds to the image that depicts the planet */
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        /*
         * we just need to use shallow copy due to the instance parameters are all basic
         * type.
         */
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * Calculate the distance between two planets
     * 
     * @param p the given planet
     * @return return the distance between the supplied planet and the planet that
     *         is doing the calculation
     */
    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(xxPos - p.xxPos, 2) + Math.pow(yyPos - p.yyPos, 2));
    }

    /**
     * Calculate the force exerted on this planet by the given planet
     * 
     * @param p the given planet
     * @return return a double describing the force exerted on this planet by the
     *         given planet
     */
    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return Planet.G * mass * p.mass / Math.pow(r, 2);
    }

    /**
     * Calculate the force exerted in the X directions
     * 
     * @param p the given planet
     * @return return a double describing the force exerted in the X directions
     */
    public double calcForceExertedByX(Planet p) {
        double dx = Math.abs(xxPos - p.xxPos);
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dx / r;
    }

    /**
     * Calculate the force exerted in the Y directions
     * 
     * @param p the given planet
     * @return return a double describing the force exerted in the Y directions
     */
    public double calcForceExertedByY(Planet p) {
        double dy = Math.abs(yyPos - p.yyPos);
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dy / r;
    }

    /**
     * Calculate the net X force exerted by all planets in that array upon
     * the current Planet
     * 
     * @param planets the given planets
     * @return return a double describing the net X force exerted by all planets in
     *         the array planets
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double netX = 0;
        for (Planet p : planets) {
            if (p == this) {
                continue;
            }
            netX += calcForceExertedByX(p);
        }
        return netX;
    }

    /**
     * Calculate the net Y force exerted by all planets in that array upon
     * the current Planet
     * 
     * @param planets the given planets
     * @return return a double describing the net Y force exerted by all planets in
     *         the array planets
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double netY = 0;
        for (Planet p : planets) {
            if (p == this) {
                continue;
            }
            netY += calcForceExertedByY(p);
        }
        return netY;
    }

    /**
     * adjust the velocity and position if an x-force of fX and a y-force of fY were
     * applied for dt seconds
     * 
     * @param dt the time interval for forces
     * @param fX force in X direction
     * @param fY force in Y direction
     */
    public void update(double dt, double fX, double fY) {
        /* a = F / m */
        double aX = fX / mass, aY = fY / mass;

        /* v = v0 + a * dt */
        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;

        /* p = p0 + v * dt */
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    /**
     * Draw this planet
     */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}