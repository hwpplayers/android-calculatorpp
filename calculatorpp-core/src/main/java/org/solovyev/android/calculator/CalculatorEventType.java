package org.solovyev.android.calculator;

import org.jetbrains.annotations.NotNull;

/**
 * User: Solovyev_S
 * Date: 20.09.12
 * Time: 16:40
 */
public enum CalculatorEventType {

    /*
    **********************************************************************
    *
    *                           CALCULATION
    *                           org.solovyev.android.calculator.CalculatorEvaluationEventData
    *
    **********************************************************************
    */


    // @NotNull CalculatorEditorViewState
    manual_calculation_requested,

    // @NotNull org.solovyev.android.calculator.CalculatorInput
    calculation_started,

    // @NotNull org.solovyev.android.calculator.CalculatorOutput
    calculation_result,

    calculation_cancelled,

    // @NotNull org.solovyev.android.calculator.CalculatorFailure
    calculation_failed,

    calculation_finished,

    /*
    **********************************************************************
    *
    *                           CONVERSION
    *                           CalculatorConversionEventData
    *
    **********************************************************************
    */
    conversion_started,

    // @NotNull String conversion result
    conversion_result,

    // @NotNull ConversionFailure
    conversion_failed,

    conversion_finished,

    /*
    **********************************************************************
    *
    *                           EDITOR
    *
    **********************************************************************
    */

    // @NotNull org.solovyev.android.calculator.CalculatorEditorChangeEventData
    editor_state_changed,

    // @NotNull CalculatorDisplayChangeEventData
    display_state_changed,

    /*
    **********************************************************************
    *
    *                           ENGINE
    *
    **********************************************************************
    */

    engine_preferences_changed,

    /*
    **********************************************************************
    *
    *                           HISTORY
    *
    **********************************************************************
    */

    // @NotNull CalculatorHistoryState
   history_state_added,

    // @NotNull CalculatorHistoryState
   use_history_state,

   clear_history_requested,

    /*
    **********************************************************************
    *
    *                           MATH ENTITIES
    *
    **********************************************************************
    */

    // @NotNull IConstant
    use_constant,

    // @NotNull Function
    use_function,

    // @NotNull Operator
    use_operator,

    // @NotNull IConstant
    constant_added,

    // @NotNull Change<IConstant>
    constant_changed,

    // @NotNull IConstant
    constant_removed;

    public boolean isOfType(@NotNull CalculatorEventType... types) {
        for (CalculatorEventType type : types) {
            if ( this == type ) {
                return true;
            }
        }

        return false;
    }

}