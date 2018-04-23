package net.atos.cedre.di.module;

import android.content.Context;

import net.atos.cedre.MainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abk on 31/03/2018.
 */

@Module
public class ApplicationModule {

    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplication() {
        return this.application;
    }
}
