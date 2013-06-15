package org.solovyev.android.calculator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.solovyev.common.listeners.JListeners;
import org.solovyev.common.listeners.Listeners;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * User: Solovyev_S
 * Date: 20.09.12
 * Time: 16:42
 */
public class ListCalculatorEventContainer implements CalculatorEventContainer {

	@Nonnull
	private static final String TAG = "CalculatorEventData";

	@Nonnull
	private final JListeners<CalculatorEventListener> listeners = Listeners.newWeakRefListeners();

	@Override
	public void addCalculatorEventListener(@Nonnull CalculatorEventListener calculatorEventListener) {
		listeners.addListener(calculatorEventListener);
	}

	@Override
	public void removeCalculatorEventListener(@Nonnull CalculatorEventListener calculatorEventListener) {
		listeners.removeListener(calculatorEventListener);
	}

	@Override
	public void fireCalculatorEvent(@Nonnull CalculatorEventData calculatorEventData, @Nonnull CalculatorEventType calculatorEventType, @Nullable Object data) {
		fireCalculatorEvents(Arrays.asList(new CalculatorEvent(calculatorEventData, calculatorEventType, data)));
	}

	@Override
	public void fireCalculatorEvents(@Nonnull List<CalculatorEvent> calculatorEvents) {
		final Collection<CalculatorEventListener> listeners = this.listeners.getListeners();

		//final CalculatorLogger logger = Locator.getInstance().getLogger();

		for (CalculatorEvent e : calculatorEvents) {
			//Locator.getInstance().getLogger().debug(TAG, "Event fired: " + e.getCalculatorEventType());
			for (CalculatorEventListener listener : listeners) {
				/*long startTime = System.currentTimeMillis();*/
				listener.onCalculatorEvent(e.getCalculatorEventData(), e.getCalculatorEventType(), e.getData());
/*                long endTime = System.currentTimeMillis();
                long totalTime = (endTime - startTime);
                if ( totalTime > 300 ) {
                    logger.debug(TAG + "_" + e.getCalculatorEventData().getEventId(), "Started event: " + e.getCalculatorEventType() + " with data: " + e.getData() + " for: " + listener.getClass().getSimpleName());
                    logger.debug(TAG + "_" + e.getCalculatorEventData().getEventId(), "Total time, ms: " + totalTime);
                }*/
			}
		}
	}
}
