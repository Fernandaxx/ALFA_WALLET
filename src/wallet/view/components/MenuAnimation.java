package wallet.view.components;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuAnimation {

    private final MigLayout layout;
    private final MenuItem menuItem;
    private Animator animator;

    public MenuAnimation(MigLayout layout, Component component) {
        this.layout = layout;
        this.menuItem = (MenuItem) component;
        initAnimator(component, 200);
    }

    public MenuAnimation(MigLayout layout, Component component, int duration) {
        this.layout = layout;
        this.menuItem = (MenuItem) component;
        initAnimator(component, duration);
    }

    private void initAnimator(Component component, int duration) {
        int height = component.getPreferredSize().height;
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float h;
                h = 40 + ((height - 40) * fraction);
                menuItem.setAlpha(fraction);

                layout.setComponentConstraints(menuItem, "h " + h + "!");
                component.revalidate();
                component.repaint();
            }
        };
        animator = new Animator(duration, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
    }

    public void openMenu() {
        animator.start();
    }

}
