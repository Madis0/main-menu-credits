package dev.isxander.mainmenucredits;

import dev.isxander.mainmenucredits.api.MainMenuCreditAPI;
import dev.isxander.mainmenucredits.config.MMCConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class MainMenuCredits implements ClientModInitializer {
    private static MainMenuCredits instance;

    private MMCConfig config;

    @Override
    public void onInitializeClient() {
        instance = this;

        config = new MMCConfig();
        config.load();

        var entrypoints = FabricLoader.getInstance().getEntrypoints("main-menu-credits", MainMenuCreditAPI.class);
        for (var api : entrypoints) {
            config.getTopLeft().addAll(api.getTopLeft());
            config.getTopRight().addAll(api.getTopRight());
            config.getBottomLeft().addAll(api.getBottomLeft());
            config.getBottomRight().addAll(api.getBottomRight());
        }
    }

    public MMCConfig getConfig() {
        return config;
    }

    public static MainMenuCredits getInstance() {
        return instance;
    }
}
