package financemanager.service;

import financemanager.model.Asset;
import financemanager.model.Liability;

import java.util.ArrayList;
import java.util.List;

public class AssetLiabilityManager {
    private List<Asset> assets;
    private List<Liability> liabilities;

    public AssetLiabilityManager() {
        this.assets = new ArrayList<>();
        this.liabilities = new ArrayList<>();
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public void addLiability(Liability liability) {
        liabilities.add(liability);
    }

    public boolean removeAsset(int id) {
        return assets.removeIf(asset -> asset.getId() == id);
    }

    public boolean removeLiability(int id) {
        return liabilities.removeIf(liability -> liability.getId() == id);
    }

    public ArrayList<Asset> getAssets() {
        return new ArrayList<>(assets);
    }

    public ArrayList<Liability> getLiabilities() {
        return new ArrayList<>(liabilities);
    }

    public double getTotalAssetValue() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.getValue();
        }
        return total;
    }

    public double getTotalLiabilityValue() {
        double total = 0;
        for (Liability liability : liabilities) {
            total += liability.getRemainingValue();
        }
        return total;
    }

}
