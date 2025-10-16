import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.TimerTask;

public class ScarierSimulator {

    private static final Random rnd = new Random();
    private static boolean simulationStarted = false;

    // --- VERIFIED & UPDATED WEBSITE LIST ---
    private static final String RICK_ROLL_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    private static final String[] SAFE_RANDOM_SITES = {
        "https://www.instagram.com/gdg.snioe/?hl=en", // The requested link
        "https://en.wikipedia.org/wiki/Special:Random", // Reliable random article
        "https://pointerpointer.com/", // Classic interactive site
        "https://neal.fun/deep-sea/", // Very cool and safe interactive page
        "https://archive.org/web/", // The Internet Archive's Wayback Machine
        "https://cat-bounce.com/" // Simple and harmless
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScarierSimulator::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        createPayloadFile();

        JFrame frame = new JFrame("Sketchy Buttons You Wouldn't Click!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new GridLayout(3, 1, 20, 20));
        frame.getContentPane().setBackground(new Color(230, 230, 230));

        frame.add(createDiscoButton(frame));
        frame.add(createOverpromiserButton(frame));

        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        linkPanel.setOpaque(false);
        linkPanel.add(createCamouflagedLink(frame));
        frame.add(linkPanel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void initiateTheSimulation(JFrame owner) {
        if (simulationStarted) return;
        simulationStarted = true;
        startChaos(owner);
    }

    // --- Button and Link Creation ---

    private static JButton createDiscoButton(JFrame owner) {
        JButton button = new JButton("✨ DOWBLOAD NOWW!! ✨");
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button.setOpaque(true);
        button.setBorderPainted(false);

        Timer timer = new Timer(150, e -> {
            Color bgColor = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            button.setBackground(bgColor);
            button.setForeground(new Color(255 - bgColor.getRed(), 255 - bgColor.getGreen(), 255 - bgColor.getBlue()));
        });
        timer.start();

        button.addActionListener(e -> {
            initiateTheSimulation(owner);
            openWebpage(SAFE_RANDOM_SITES[rnd.nextInt(SAFE_RANDOM_SITES.length)]);
        });
        return button;
    }

    private static JButton createOverpromiserButton(JFrame owner) {
        String buttonText = "<html><center>"
                + "<h1>FREE DOWNLOAD!</h1><p>🚀 INSTANT & FASTEST! 🚀</p>"
                + "<p><b>100% SECURE & VIRUS-FREE (GUARANTEED!)</b></p>"
                + "</center></html>";
        JButton button = new JButton(buttonText);
        button.setBackground(Color.YELLOW);
        button.setForeground(Color.RED);
        button.setFont(new Font("Arial", Font.BOLD, 16));

        button.addActionListener(e -> {
            initiateTheSimulation(owner);
            openWebpage(RICK_ROLL_URL);
        });
        return button;
    }

    private static JLabel createCamouflagedLink(JFrame owner) {
        String labelText = "<html><p>...to continue reading, please <font color='blue'><u>click here to update your drivers</u></font>...</p></html>";
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                initiateTheSimulation(owner);
                openWebpage(SAFE_RANDOM_SITES[rnd.nextInt(SAFE_RANDOM_SITES.length)]);
            }
        });
        return label;
    }

    // --- Payload and Web Actions ---

    private static void createPayloadFile() {
        String desktopPath = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop";
        java.io.File payloadFile = new java.io.File(desktopPath, "Arhaan Arora's Rules.txt");

        try (PrintWriter writer = new PrintWriter(payloadFile)) {
            writer.println("=============================");
            writer.println("  ARHAAN ARORA's PC - RULES  ");
            writer.println("=============================");
            writer.println("\nRule #1: This device is now under my control.");
            writer.println("Rule #2: Do not attempt to turn off the computer.");
            writer.println("Rule #3: All your data belongs to me now.");
            writer.println("Rule #4: Enjoy the show. :)");

            JOptionPane.showMessageDialog(null,
                "A file named 'Arhaan Arora's Rules.txt' was successfully created on your Desktop.",
                "File Created", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                "Could not create file on Desktop.\nPlease check permissions.\n" + e.getMessage(),
                "File Creation Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (IOException | URISyntaxException ex) {
            System.err.println("Error: Could not open link. " + ex.getMessage());
        }
    }

    // --- Chaos Simulation Engine ---

    private static void startChaos(JFrame owner) {
        java.util.Timer t = new java.util.Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() { SwingUtilities.invokeLater(() -> spawnRandomPopup(owner)); }
        }, 800, 1500 + rnd.nextInt(2000));
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() { SwingUtilities.invokeLater(() -> showNotificationBubble(owner, randomToastText())); }
        }, 1200, 4000 + rnd.nextInt(5000));
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() { if (rnd.nextDouble() < 0.15) SwingUtilities.invokeLater(() -> showFakeBSOD(owner)); }
        }, 6000, 8000);
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() { if (rnd.nextDouble() < 0.25) SwingUtilities.invokeLater(() -> showWindowsStyleError(owner)); }
        }, 2000, 6000);
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (rnd.nextDouble() < 0.25) {
                    String url = rnd.nextDouble() < 0.30 ? RICK_ROLL_URL : SAFE_RANDOM_SITES[rnd.nextInt(SAFE_RANDOM_SITES.length)];
                    openWebpage(url);
                }
            }
        }, 7000, 10000);

        t.schedule(new TimerTask() {
            public void run() {
                t.cancel();
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(owner, "Simulation finished.", "Complete", JOptionPane.INFORMATION_MESSAGE));
            }
        }, 120_000); // Stop after 2 minutes
    }

    private static void spawnRandomPopup(JFrame owner) {
        String[] msgs = { "ARHAAN ARORA has hacked you.", "Your files are being encrypted...", "C:\\Windows\\system32\\kernel32.dll failed to load.", "Application error: 0xC0000005", "Security violation detected.", "Fatal Error: Memory could not be read.", "System registry corrupted.", "Network Connection Lost.", "TROJAN detected in svchost.exe" };
        int type = rnd.nextInt(3);
        String message = msgs[rnd.nextInt(msgs.length)] + "\n" + randomAdvice();
        int msgType = (type == 0) ? JOptionPane.ERROR_MESSAGE : (type == 1) ? JOptionPane.WARNING_MESSAGE : JOptionPane.INFORMATION_MESSAGE;

        JDialog dialog = new JDialog(owner, "System Alert", false);
        dialog.setUndecorated(true);
        dialog.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        dialog.add(createMessagePanel(message, msgType));
        dialog.pack();
        Rectangle r = owner.getBounds();
        dialog.setLocation(r.x + rnd.nextInt(Math.max(1, r.width - dialog.getWidth())),
                           r.y + rnd.nextInt(Math.max(1, r.height - dialog.getHeight())));
        Timer closeTimer = new Timer(2200 + rnd.nextInt(3000), ev -> dialog.dispose());
        closeTimer.setRepeats(false);
        closeTimer.start();
        Toolkit.getDefaultToolkit().beep();
        dialog.setVisible(true);
    }

    private static JPanel createMessagePanel(String message, int messageType) {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBackground(new Color(245, 245, 245));
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        Icon icon = (messageType == JOptionPane.ERROR_MESSAGE) ? UIManager.getIcon("OptionPane.errorIcon") : (messageType == JOptionPane.WARNING_MESSAGE) ? UIManager.getIcon("OptionPane.warningIcon") : UIManager.getIcon("OptionPane.informationIcon");
        p.add(new JLabel(icon), BorderLayout.WEST);
        JTextArea ta = new JTextArea(message);
        ta.setEditable(false);
        ta.setOpaque(false);
        ta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        p.add(ta, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        buttons.setOpaque(false);
        JButton ok = new JButton("OK");
        ok.addActionListener(e -> ((Window) ok.getTopLevelAncestor()).dispose());
        buttons.add(ok);
        p.add(buttons, BorderLayout.SOUTH);
        return p;
    }

    private static void showNotificationBubble(JFrame owner, String text) {
        JWindow bubble = new JWindow(owner);
        JPanel content = new JPanel(new BorderLayout(6, 6));
        content.setBackground(new Color(240, 240, 240, 230));
        content.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        JLabel lbl = new JLabel("<html><b>Windows Security</b><br/><small>" + text + "</small></html>");
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        content.add(lbl);
        bubble.add(content);
        bubble.pack();
        Rectangle r = owner.getBounds();
        bubble.setLocation(r.x + r.width - bubble.getWidth() - 20, r.y + r.height - bubble.getHeight() - 40);
        bubble.setVisible(true);
        Toolkit.getDefaultToolkit().beep();
        final float[] opacity = {1.0f};
        Timer fade = new Timer(80, null);
        fade.addActionListener(ev -> {
            opacity[0] -= 0.12f;
            if (opacity[0] <= 0f) {
                fade.stop(); bubble.dispose();
            } else { try { bubble.setOpacity(opacity[0]); } catch (Throwable ignored) { fade.stop(); bubble.dispose(); } }
        });
        Timer delay = new Timer(1600 + rnd.nextInt(2000), ev -> fade.start());
        delay.setRepeats(false);
        delay.start();
    }

    // --- NEW: SCARIER BLUE SCREEN OF DEATH ---
    private static void showFakeBSOD(JFrame owner) {
        final JWindow bsod = new JWindow();
        bsod.setAlwaysOnTop(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        bsod.setBounds(0, 0, screen.width, screen.height);

        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(new Color(0, 78, 173)); // Classic BSOD blue

        JTextArea ta = new JTextArea(); // We will update this text
        ta.setEditable(false);
        ta.setOpaque(false);
        ta.setForeground(Color.WHITE);
        ta.setFont(new Font("Consolas", Font.PLAIN, 22));
        ta.setBorder(new EmptyBorder(80, 80, 80, 80));
        p.add(ta);

        bsod.add(p);
        bsod.setVisible(true);
        Toolkit.getDefaultToolkit().beep();

        // Timer to animate the "progress" counter
        final int[] progress = {0};
        Timer progressTimer = new Timer(400, e -> {
            progress[0] += rnd.nextInt(15) + 5; // Increment by a random amount
            if (progress[0] > 100) progress[0] = 100;

            String bsodText = String.format(
                ":(\n\n" +
                "Your PC ran into a fatal problem and needs to shut down. We are\n" +
                "collecting some error info, and then we'll restart for you.\n\n" +
                "%d%% complete\n\n" +
                "For more information about this issue and possible fixes, visit\n" +
                "https://windows.com/stopcode\n\n" +
                "If you call a support person, give them this info:\n" +
                "Stop Code: CRITICAL_PROCESS_DIED_ARHAAN\n" +
                "What failed: svchost.exe (ntoskrnl.exe)",
                progress[0]
            );
            ta.setText(bsodText);
        });
        progressTimer.setInitialDelay(0);
        progressTimer.start();

        // Timer to close the BSOD after a few seconds
        Timer closeTimer = new Timer(4500 + rnd.nextInt(2000), e -> {
            progressTimer.stop();
            bsod.dispose();
        });
        closeTimer.setRepeats(false);
        closeTimer.start();
    }


    private static void showWindowsStyleError(JFrame owner) {
        JDialog d = new JDialog(owner, "Program Error", false);
        d.setUndecorated(true);
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(10, 36, 106));
        titleBar.setPreferredSize(new Dimension(400, 30));
        titleBar.add(new JLabel(" Program has stopped responding") {{setForeground(Color.WHITE);}}, BorderLayout.WEST);
        JButton x = new JButton("X") {{ setMargin(new Insets(0,0,0,0)); setBackground(new Color(10, 36, 106)); setForeground(Color.WHITE); setFocusPainted(false); setBorder(null); addActionListener(e -> d.dispose()); }};
        titleBar.add(x, BorderLayout.EAST);
        outer.add(titleBar, BorderLayout.NORTH);
        JPanel content = new JPanel(new BorderLayout(10,10));
        content.setBackground(new Color(245, 245, 245));
        content.setBorder(new EmptyBorder(10, 10, 10, 10));
        content.add(new JLabel(UIManager.getIcon("OptionPane.errorIcon")), BorderLayout.WEST);
        content.add(new JTextArea("The program unexpectedly quit.\nFaulting module: arhaan.dll\nStatus: 0xDEADBEEF") {{setEditable(false); setOpaque(false); setFont(new Font("Segoe UI", Font.PLAIN, 12));}}, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.setOpaque(false);
        JButton close = new JButton("Close program");
        close.addActionListener(e -> { d.dispose(); Toolkit.getDefaultToolkit().beep(); spawnRandomPopup(owner); });
        buttons.add(close);
        content.add(buttons, BorderLayout.SOUTH);
        outer.add(content, BorderLayout.CENTER);
        d.add(outer);
        d.pack();
        d.setLocationRelativeTo(owner);
        d.setVisible(true);
    }

    private static String randomToastText() {
        String[] t = {"Update available for C:\\Windows\\System32", "Potential threat blocked", "Unusual sign-in attempt detected", "System backup failed"};
        return t[rnd.nextInt(t.length)];
    }

    private static String randomAdvice() {
        String[] adv = {"Press OK to continue.", "Do not turn off your computer.", "Running diagnostics...", "Attempting recovery..."};
        return adv[rnd.nextInt(adv.length)];
    }
}