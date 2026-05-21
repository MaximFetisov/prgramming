package client.commands;

import client.managers.NetworkManager;
import common.CommandResponse;

import java.awt.Desktop;
import java.net.URI;
import java.net.DatagramSocket;

/**
 * Скрытая команда для рикролла.
 * Открывает видео с Rick Astley - Never Gonna Give You Up
 */
public class Never {

    public CommandResponse execute(DatagramSocket socket,
                                   NetworkManager networkManager,
                                   String host,
                                   int port) {
        try {
            System.out.println("\n╔═══════════════════════════════════════════════════════╗");
            System.out.println("║                                                       ║");
            System.out.println("║          🎵 NEVER GONNA GIVE YOU UP 🎵                ║");
            System.out.println("║                                                       ║");
            System.out.println("║  We're no strangers to love...                       ║");
            System.out.println("║  You know the rules and so do I...                   ║");
            System.out.println("║                                                       ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝\n");

            // Ссылка на видео
            String videoUrl = "https://vkvideo.ru/video-127960182_456239022";

            // Открываем видео в браузере
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(videoUrl));
                System.out.println("▶️  Видео открыто в браузере!");
            } else {
                System.out.println("▶️  Ссылка на видео: " + videoUrl);
            }

            System.out.println("\n🎵 You know the rules... 🎵\n");

            return new CommandResponse(true, "Never gonna give you up!");

        } catch (Exception e) {
            return new CommandResponse(false, "Ошибка: " + e.getMessage());
        }
    }
}