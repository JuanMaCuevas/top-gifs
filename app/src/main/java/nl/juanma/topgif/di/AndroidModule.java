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

import nl.juanma.topgif.App;
import nl.juanma.topgif.datasource.Reddit;
import nl.juanma.topgif.interactor.GifCommander;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module(library = true,
        injects = {GifCommander.class
        })
public class AndroidModule {
    App application;

    public AndroidModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("http://www.reddit.com")
                .build();
    }

    @Provides
    @Singleton Reddit provideGithub(RestAdapter restAdapter) {
        return restAdapter.create(Reddit.class);
    }
}
