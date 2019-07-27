package com.yerti.pastnameplaceholder.api;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import com.yerti.pastnameplaceholder.PastNamePlaceholder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Placeholders extends EZPlaceholderHook {

    private PastNamePlaceholder pl;
    public Placeholders(PastNamePlaceholder pl) {

        super(pl, "playercheck");

        this.pl = pl;
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        if (p == null) {
            return "";
        }
        // placeholder: %playercheck_getnames%
        if (identifier.equals("getnames")) {
            p.sendMessage(ChatColor.GREEN + "Found placeholder.");
            List<String> names = new ArrayList<>();

            try {
                p.sendMessage(ChatColor.GREEN + "Getting previous names...");
                GetPastUUID.PreviousPlayerNameEntry[] previousNames = GetPastUUID.getPlayerPreviousNames(p.getUniqueId());
                for (GetPastUUID.PreviousPlayerNameEntry entry : previousNames) {
                    p.sendMessage(ChatColor.GREEN + "Looping through past UUIDs...");
                    names.add(entry.getPlayerName() + " ");
                }
            } catch (IOException e) {
                p.sendMessage(ChatColor.RED + "An exception occured.!");
                e.printStackTrace();
            }

            if (names == null) {
                p.sendMessage(ChatColor.RED + "No names were found");
            }

            p.sendMessage(ChatColor.RED + "End result: " + names.toString());
            return names.toString();
        }

        return null;
    }

}
