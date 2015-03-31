/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.juanma.topgif.di;

import nl.juanma.topgif.ui.activity.BaseActivity;
import nl.juanma.topgif.ui.activity.MainActivity;
import nl.juanma.topgif.ui.view.SuggestionsBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                MainActivity.class, SuggestionsBox.class
        },
        addsTo = AndroidModule.class,
        library = true
)
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton BaseActivity provideActivityContext() {
        return activity;
    }
}
