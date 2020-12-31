/*
 * This file is part of TabTPS, licensed under the MIT License.
 *
 * Copyright (c) 2020-2021 Jason Penilla
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package xyz.jpenilla.tabtps.util;

import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.jpenilla.jmplib.Environment;
import xyz.jpenilla.tabtps.TabTPS;

public class PingUtil {
  private final TabTPS tabTPS;

  public PingUtil(final @NonNull TabTPS tabTPS) {
    this.tabTPS = tabTPS;
  }

  public int ping(final @NonNull Player player) {
    return Environment.majorMinecraftVersion() < 16 || !Environment.paper() ? this.tabTPS.nmsHandler().ping(player) : player.spigot().getPing();
  }

  public String coloredPing(final @NonNull Player player) {
    return coloredPing(this.ping(player));
  }

  public static String coloredPing(final int ping) {
    final String color;
    if (ping < 100) {
      color = "green:dark_green";
    } else if (ping < 250) {
      color = "yellow:#FFC500";
    } else {
      color = "red:#FF4300";
    }
    return "<gradient:" + color + ">" + ping + "</gradient>";
  }
}