package com.leaguechampions.ui.settings;

import android.content.SharedPreferences;
import android.view.MenuItem;

import com.leaguechampions.BuildConfig;
import com.leaguechampions.utils.PrefUtils;
import com.leaguechampions.utils.ReflectionUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BuildConfig.class, PrefUtils.class})
public class SettingsPresenterTest {

    private SettingsPresenter presenter;

    private final String fieldBuildType = "buildType";

    @Mock SettingsPresenter.SettingsView view;
    @Mock SharedPreferences sharedPreferences;

    @Before
    public void setUp() {
        presenter = new SettingsPresenter(view, sharedPreferences);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testOnActivityCreated() {
        PowerMockito.mockStatic(PrefUtils.class);
        when(PrefUtils.isMockMode(sharedPreferences)).thenReturn(true);
        ReflectionUtils.setField(presenter, fieldBuildType, "debug");

        presenter.onActivityCreated(null, null);

        verify(view).setVersion(BuildConfig.VERSION_NAME);
        verify(view).showDeveloperOptions();
        verify(view).showMockMode(true);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void testOnActivityCreated_WhenBuildTypeRelease_OnlySetsVersion() {
        PowerMockito.mockStatic(PrefUtils.class);
        ReflectionUtils.setField(presenter, fieldBuildType, "release");

        presenter.onActivityCreated(null, null);

        verify(view).setVersion(BuildConfig.VERSION_NAME);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void testOnOptionsItemSelected() {
        MenuItem item = mock(MenuItem.class);
        when(item.getItemId()).thenReturn(android.R.id.home);

        boolean result = presenter.onOptionsItemSelected(item);

        assertThat(result).isEqualTo(true);
        verify(view).doFinish();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void testOnOptionsItemSelected_WhenItemNotHome_DoNothing() {
        MenuItem item = mock(MenuItem.class);
        when(item.getItemId()).thenReturn(0);

        boolean result = presenter.onOptionsItemSelected(item);

        assertThat(result).isEqualTo(false);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void testOnMockModeCheckedChanged() {
        // TODO create tests for PrefUtils
        PowerMockito.mockStatic(PrefUtils.class);

        presenter.onMockModeCheckedChanged(true);

        verifyNoMoreInteractions(view);
    }
}
