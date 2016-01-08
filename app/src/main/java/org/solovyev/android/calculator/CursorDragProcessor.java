/*
 * Copyright 2013 serso aka se.solovyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Contact details
 *
 * Email: se.solovyev@gmail.com
 * Site:  http://se.solovyev.org
 */

package org.solovyev.android.calculator;

import android.graphics.PointF;
import android.view.MotionEvent;

import org.solovyev.android.views.dragbutton.DirectionDragButton;
import org.solovyev.android.views.dragbutton.DragButton;
import org.solovyev.android.views.dragbutton.DragDirection;
import org.solovyev.android.views.dragbutton.SimpleDragListener;

import javax.annotation.Nonnull;

public class CursorDragProcessor implements SimpleDragListener.DragProcessor {

    @Override
    public boolean processDragEvent(@Nonnull DragDirection dragDirection, @Nonnull DragButton dragButton, @Nonnull PointF startPoint, @Nonnull MotionEvent motionEvent) {
        if (dragButton instanceof DirectionDragButton) {
            final String text = ((DirectionDragButton) dragButton).getText(dragDirection);
            if ("◁◁".equals(text)) {
                Locator.getInstance().getEditor().setCursorOnStart();
                return true;
            } else if ("▷▷".equals(text)) {
                Locator.getInstance().getEditor().setCursorOnEnd();
                return true;
            }
        }

        return false;
    }
}