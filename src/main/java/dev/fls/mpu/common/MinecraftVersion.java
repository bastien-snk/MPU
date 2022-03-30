package dev.fls.mpu.common;

import lombok.RequiredArgsConstructor;

/**
 * This documents manipulates all Minecraft  version related methods.
 * It is based on Minecraft official protocol.
 *
 * From v1.7.2 - 1.18.2
 *
 * @see <a href="https://wiki.vg/Protocol_version_numbers#Versions_before_the_Netty_rewrite">Source</a>
 * @author Bastien S. <a href="https://github.com/rootxls">My GitHub</a>
 * @version 1.0 (March 2022)
 * @since Minecraft 1.7
 */
@RequiredArgsConstructor
public enum MinecraftVersion {

    /**
     * Codes:
     * • V -> Official Version
     * • B -> Beta Version
     * • A -> Alpha Version
     */

    V1_18(757, 758, "1.18"),
    V1_17(755, 756, "1.17"),
    V1_16(701, 754, "1.16"),
    V1_15(550, 578, "1.15"),
    V1_14(441, 498, "1.14"),
    V1_13(341, 404, "1.13"),
    V1_12(317, 340, "1.12"),
    V1_11(301, 316, "1.11"),
    V1_10(201, 210, "1.10"),
    V1_9(49, 110, "1.9"),
    V1_8(6, 48, "1.8"),
    V1_7(0, 5, "1.7")
    ;

    private final int start, end;
    private final String displayName;

    public String getDisplayName() {
        return "Minecraft " + displayName;
    }

    /**
     * Get fetch a {@link MinecraftVersion} from protocol ID
     * @param protocol
     * @return
     */
    public static MinecraftVersion getVersion(int protocol) {
        for (MinecraftVersion version : MinecraftVersion.values()) {
            boolean sameProtocol = protocol >= version.start && protocol <= version.end;
            if(!sameProtocol) continue;

            return version;
        }

        return null;
    }

}
