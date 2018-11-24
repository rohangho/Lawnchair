/*
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.deletescape.lawnchair.root

import com.android.launcher3.BuildConfig
import eu.chainfire.librootjava.RootIPC

class RootHelper : IRootHelper.Stub() {

    override fun goToSleep() {
        RootHelperUtils.goToSleep()
    }

    companion object {

        @JvmStatic
        fun main(vararg args: String) {
            try {
                RootIPC(BuildConfig.APPLICATION_ID, RootHelper(), 0, 30 * 1000, true)
            } catch (e: RootIPC.TimeoutException) {
                // a connection wasn't established
            }

        }
    }
}
