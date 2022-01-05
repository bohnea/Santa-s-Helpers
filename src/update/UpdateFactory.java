package update;

import child.ChildFactory;
import gift.GiftFactory;
import io.input.update.AnnualUpdateInput;
import io.input.update.ChildUpdateInput;

public class UpdateFactory {
    public static class AnnualUpdateFactory {
        public static AnnualUpdate createAnnualUpdate(AnnualUpdateInput annualUpdateInput) {
            return new AnnualUpdate(
                    annualUpdateInput.getNewSantaBudget(),
                    annualUpdateInput.getNewGifts().stream()
                            .map(GiftFactory::createGift).toList(),
                    annualUpdateInput.getNewChildren().stream()
                            .map(ChildFactory::createChild).toList(),
                    annualUpdateInput.getChildrenUpdates().stream()
                            .map(ChildUpdateFactory::createChildUpdate).toList()
            );
        }
    }

    public static class ChildUpdateFactory {
        public static ChildUpdate createChildUpdate(ChildUpdateInput childUpdateInput) {
            return new ChildUpdate(
                    childUpdateInput.getId(),
                    childUpdateInput.getNiceScore(),
                    childUpdateInput.getGiftsPreferences()
            );
        }
    }
}
