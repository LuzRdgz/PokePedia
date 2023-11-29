import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class elementosCarta {
    public static String pokemon, descriptionURL, imageURL, ability, numpk, name, tipo, hp, effect, shortEffect, attack, defense, specialAttack , specialDefense,speed;
    public static int rc;
    static Scanner scan;
    static StringBuilder sb;
    static JSONObject jsonObj;
    static HttpURLConnection conn;
    static URL url;

    public void procesarElementosCartaJSON(){

        try {
            pokemon = "25";
            url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemon);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            rc = conn.getResponseCode();
            if(rc != 200) {
                System.out.println("Error "+ rc);
            }
            else {
                sb = new StringBuilder();
                scan = new Scanner(url.openStream());
                while(scan.hasNext()) {
                    sb.append(scan.nextLine());
                }
                scan.close();
                jsonObj = new JSONObject(String.valueOf(sb));
                //System.out.println(dataObject.names());
                hp = String.valueOf((jsonObj.getJSONArray("stats").getJSONObject(0).getInt("base_stat")));
                attack = String.valueOf((jsonObj.getJSONArray("stats").getJSONObject(1).getInt("base_stat")));
                defense = String.valueOf((jsonObj.getJSONArray("stats").getJSONObject(2).getInt("base_stat")));
                specialAttack = String.valueOf((jsonObj.getJSONArray("stats").getJSONObject(3).getInt("base_stat")));
                specialDefense = String.valueOf((jsonObj.getJSONArray("stats").getJSONObject(4).getInt("base_stat")));
                speed = String.valueOf((jsonObj.getJSONArray("stats").getJSONObject(5).getInt("base_stat")));
                tipo = jsonObj.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");
                name = String.valueOf(jsonObj.getString("name"));
                numpk = String.valueOf(jsonObj.getInt("id"));
                ability = String.valueOf(jsonObj.getJSONArray("abilities").getJSONObject(0).getJSONObject("ability").getString("name"));
                descriptionURL = String.valueOf(jsonObj.getJSONArray("abilities").getJSONObject(0).getJSONObject("ability").getString("url"));
                imageURL = String.valueOf(jsonObj.getJSONObject("sprites").getJSONObject("other").getJSONObject("official-artwork").getString("front_default"));

                procesarDescripcion();
                descargarImagen();

                System.out.println("Pokemon: "+ name);
                System.out.println("Numero: " + numpk);
                System.out.println("BASE STATS");
                System.out.println("HP: " + hp);
                System.out.println("Attack: " + attack);
                System.out.println("Defense: " + defense);
                System.out.println("Special Attack: " + specialAttack);
                System.out.println("Special Defense: " + specialDefense);
                System.out.println("Speed: " + speed);
                System.out.println("Tipo: " + tipo);
                System.out.println("Habilidad: " + ability);
                System.out.println("Descripcion: ");
                //effect.replace("\n"," ");
                if (effect != null && shortEffect != null){
                    System.out.println("-> Effect: " + effect.replace("\n"," "));
                    System.out.println("-> Short Effect: " + shortEffect);
                }else{
                    System.out.println("La pagina pokeapi.co no cuenta con la descripcion");
                }
                System.out.println("Imagen: " + imageURL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void procesarDescripcion(){

        try {
            url = new URL(descriptionURL);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
             rc = conn.getResponseCode();
            if(rc != 200) {
                System.out.println("Error"+ rc);
            }
            else {
                sb = new StringBuilder();
                scan =new Scanner(url.openStream());
                while(scan.hasNext()) {
                    sb.append(scan.nextLine());
                }
                scan.close();
                jsonObj = new JSONObject(String.valueOf(sb));
                effect = String.valueOf(jsonObj.getJSONArray("effect_entries").getJSONObject(1).getString("effect"));
                shortEffect = String.valueOf(jsonObj.getJSONArray("effect_entries").getJSONObject(1).getString("short_effect"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void descargarImagen(){

        InputStream input = null;
        url = null;

        try {
            url = new URL(imageURL);
            input = url.openStream();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            e.printStackTrace();
        }

        String file = url.getFile();
        int pos = file.lastIndexOf("/");
        String fileName = file.substring(pos + 1);

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            int data;
            while ( (data = input.read()) != -1 ) {
                outputStream.write(data);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
