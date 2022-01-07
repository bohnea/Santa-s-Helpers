package update;

import child.ChildFactory;
import gift.GiftFactory;
import io.input.update.AnnualUpdateInput;
import io.input.update.ChildUpdateInput;
import update.assignmentstrategy.AssignmentStrategyFactory;

public class UpdateFactory {
    public static class AnnualUpdateFactory {
        /**
         * Creates a new AnnualUpdate based on the given AnnualUpdateInput.
         * @param annualUpdateInput the annual update input to turn into an annual update
         * @return the created annual update
         */
        public static AnnualUpdate createAnnualUpdate(final AnnualUpdateInput annualUpdateInput) {
            return new AnnualUpdate(
                    annualUpdateInput.getNewSantaBudget(),
                    annualUpdateInput.getNewGifts().stream()
                            .map(GiftFactory::createGift).toList(),
                    annualUpdateInput.getNewChildren().stream()
                            .map(ChildFactory::createChild).toList(),
                    annualUpdateInput.getChildrenUpdates().stream()
                            .map(ChildUpdateFactory::createChildUpdate).toList(),
                    AssignmentStrategyFactory.createGiftStrategy(annualUpdateInput.getStrategy())
            );
        }
    }

    public static class ChildUpdateFactory {
        /**
         * Creates a new ChildUpdate based on the given ChildUpdateInput.
         * @param childUpdateInput the child update input to turn into a child update
         * @return the created child update
         */
        public static ChildUpdate createChildUpdate(final ChildUpdateInput childUpdateInput) {
            return new ChildUpdate(
                    childUpdateInput.getId(),
                    childUpdateInput.getNiceScore(),
                    childUpdateInput.getGiftsPreferences(),
                    childUpdateInput.getElf()
            );
        }
    }
}
