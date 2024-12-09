package dao;

import redis.clients.jedis.Jedis;

public class Bdd {
    public static Jedis connectRedis() {
        Jedis jedis = new Jedis();
        System.out.println("Connexion à Redis réussie !\n");
        return jedis;
    }
}
