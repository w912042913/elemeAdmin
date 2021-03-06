package neusoft.view;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodView {
    public void showFoodList(Integer businessId);
    public void saveFood(Integer businessId);
    public void updateFood(Integer businessId);
    public void removeFood(Integer businessId);
}
