package pokepedia;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

public class FrameBusqueda extends javax.swing.JFrame {

   private static final Logger LOGGER = Logger.getLogger(FrameBusqueda.class.getName());
    private DefaultComboBoxModel<String> tipoPokeModel;
    private DefaultComboBoxModel<String> nombrePokeModel;
    
    public FrameBusqueda() {
        initComponents();
        tipoPokeModel = new DefaultComboBoxModel<>();
        nombrePokeModel = new DefaultComboBoxModel<>();
        tipoPoke.setModel(tipoPokeModel);
        nombrePoke.setModel(nombrePokeModel);

        nombre.setVisible(false);
        nombrePoke.setVisible(false);

        agregarTiposDesdeAPI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipoPoke = new javax.swing.JComboBox<>();
        nombre = new javax.swing.JLabel();
        nombrePoke = new javax.swing.JComboBox<>();
        showCard = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        showSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PokePedia.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("TIPOS DE POKÉMON");

        tipoPoke.setBackground(new java.awt.Color(254, 202, 27));
        tipoPoke.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tipoPoke.setForeground(new java.awt.Color(55, 97, 168));
        tipoPoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPokeActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        nombre.setForeground(new java.awt.Color(51, 51, 51));
        nombre.setText("NOMBRE DEL POKÉMON");

        nombrePoke.setBackground(new java.awt.Color(254, 202, 27));
        nombrePoke.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        nombrePoke.setForeground(new java.awt.Color(55, 97, 168));
        nombrePoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrePokeActionPerformed(evt);
            }
        });

        showCard.setBackground(new java.awt.Color(254, 202, 27));
        showCard.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        showCard.setForeground(new java.awt.Color(55, 97, 168));
        showCard.setText("Mostrar carta");
        showCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCardActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(55, 97, 168));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 202, 27));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 202, 27));
        jLabel4.setText("—");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        showSearch.setBackground(new java.awt.Color(254, 202, 27));
        showSearch.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        showSearch.setForeground(new java.awt.Color(55, 97, 168));
        showSearch.setText("Búsqueda manual");
        showSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(90, 90, 90))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombre)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombrePoke, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(showCard)
                        .addGap(36, 36, 36)
                        .addComponent(showSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoPoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrePoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showCard)
                    .addComponent(showSearch))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nombrePokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrePokeActionPerformed
        
    }//GEN-LAST:event_nombrePokeActionPerformed

    private void tipoPokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPokeActionPerformed
         String tipoSeleccionado = tipoPoke.getSelectedItem().toString();

        nombrePokeModel.removeAllElements();
        try {
            agregarNombresDesdeAPI(tipoSeleccionado);
            boolean mostrarComponentes = nombrePokeModel.getSize() > 0;
            nombre.setVisible(mostrarComponentes);
            nombrePoke.setVisible(mostrarComponentes);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener nombres desde la API", e);
        }
    }//GEN-LAST:event_tipoPokeActionPerformed

    private void showCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCardActionPerformed
        String pokemonName = nombrePoke.getSelectedItem().toString();
        PokemonCard pokemon = buscarPokemon(pokemonName);
        

    if (pokemon != null) {
        CartaPokemon cp = new CartaPokemon();
        cp.setPokemonInfo(pokemon.getName(), pokemon.getType(), pokemon.getImageUrl(), 
                pokemon.getHP(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(),
                pokemon.getSpecialDefense(), pokemon.getSpeed(), pokemon.getAbility()
        );
        cp.setVisible(true);

        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Pokémon no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_showCardActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JFrame frameBusqueda = new JFrame();
    
    frameBusqueda.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private int xMouse, yMouse;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       this.setLocation(
                this.getLocation().x + evt.getX() - xMouse, 
                this.getLocation().y + evt.getY() - yMouse
                );
    }//GEN-LAST:event_formMouseDragged

    private void showSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSearchActionPerformed
        BusquedaManual bm = new BusquedaManual();
        bm.setVisible(true);
        dispose();
    }//GEN-LAST:event_showSearchActionPerformed

     private void agregarTiposDesdeAPI() {
        try {
            URL url = new URL("https://pokeapi.co/api/v2/type");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

        
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                JsonArray tipos = JsonParser.parseString(response.toString()).getAsJsonObject().getAsJsonArray("results");

                for (int i = 0; i < tipos.size(); i++) {
                    JsonObject tipo = tipos.get(i).getAsJsonObject();
                    String nombreTipo = tipo.get("name").getAsString();
                    tipoPokeModel.addElement(nombreTipo);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener tipos desde la API", e);
        }
    }
    
   private void agregarNombresDesdeAPI(String tipo) throws IOException {
        URL url = new URL("https://pokeapi.co/api/v2/type/" + tipo);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            JsonArray pokemons = JsonParser.parseString(response.toString()).getAsJsonObject().getAsJsonArray("pokemon");

            for (int i = 0; i < pokemons.size(); i++) {
                JsonObject pokemon = pokemons.get(i).getAsJsonObject().getAsJsonObject("pokemon");
                String nombrePokemon = pokemon.get("name").getAsString();
                nombrePokeModel.addElement(nombrePokemon);
            }
        }
    }
   
    private PokemonCard buscarPokemon(String pokemonName) {
    try {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase();
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();

        String name = jsonResponse.get("name").getAsString();
        JsonArray typesArray = jsonResponse.getAsJsonArray("types");
        String type = typesArray.get(0).getAsJsonObject().getAsJsonObject("type").get("name").getAsString();
        String imageUrl = jsonResponse.getAsJsonObject("sprites").get("front_default").getAsString();
        String baseExperience = jsonResponse.get("base_experience").getAsString();
        String ability = "";
        JsonArray abilitiesArray = jsonResponse.getAsJsonArray("abilities");
        if (!abilitiesArray.isJsonNull() && abilitiesArray.size() > 0) {
            ability = abilitiesArray.get(0).getAsJsonObject().getAsJsonObject("ability").get("name").getAsString();
        }

        String hp = "0";
        String att = "0";
        String defense = "0";
        String SA = "0";
        String SD = "0";
        String speed = "0";
        JsonArray statsArray = jsonResponse.getAsJsonArray("stats");
        for (JsonElement stat : statsArray) {
            String statName = stat.getAsJsonObject().getAsJsonObject("stat").get("name").getAsString();
            if ("hp".equals(statName)) {
                hp = stat.getAsJsonObject().get("base_stat").getAsString();
            } else if ("attack".equals(statName)) {
                att = stat.getAsJsonObject().get("base_stat").getAsString();
            } else if ("defense".equals(statName)) {
                defense = stat.getAsJsonObject().get("base_stat").getAsString();
            } else if ("special-attack".equals(statName)) {
                SA = stat.getAsJsonObject().get("base_stat").getAsString();
            } else if ("special-defense".equals(statName)) {
                SD = stat.getAsJsonObject().get("base_stat").getAsString();
            } else if ("speed".equals(statName)) {
                speed = stat.getAsJsonObject().get("base_stat").getAsString();
            }
        }

        return new PokemonCard(name, type, imageUrl, hp, att, defense, SA, SD, speed, ability);


    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
   
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        try {
            FileHandler fileHandler = new FileHandler("pokepedia.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al configurar el Logger", e);
        }
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameBusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombre;
    private javax.swing.JComboBox<String> nombrePoke;
    private javax.swing.JButton showCard;
    private javax.swing.JButton showSearch;
    private javax.swing.JComboBox<String> tipoPoke;
    // End of variables declaration//GEN-END:variables
}
