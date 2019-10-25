package hell.interfaces;

import java.util.List;

/**
 *  This is the interface for the RecipeItem entity
 *  Extends the Item interface
 *  @method List<String> getRequiredItems() - a getter for the requiredItems property of the RecipeItem
 */
public interface Recipe extends Item {
    List<String> getRequiredItems();
}