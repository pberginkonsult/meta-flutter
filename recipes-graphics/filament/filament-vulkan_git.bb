SUMMARY = "Lightweight 3D Render Engine"
DESCRIPTION = "Filament is a real-time physically based rendering engine for Android, iOS, Windows, Linux, macOS, and WebGL2"
AUTHOR = "Filament Authors"
HOMEPAGE = "https://github.com/google/filament"
BUGTRACKER = "https://github.com/google/filament/issues"
SECTION = "graphics"
CVE_PRODUCT = ""
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://github.com/meta-flutter/filament;protocol=https;branch=wayland"
SRCREV = "32a73d8db2cea4ed91735830dd2eed36f84cc511"

DEPENDS_append_class-target = " \
    glib-2.0 \
    virtual/egl \
    wayland \
    wayland-native \
    wayland-protocols \
"

REQUIRED_DISTRO_FEATURES = "wayland vulkan"

S = "${WORKDIR}/git"

inherit cmake

TOOLCHAIN = "clang"

RUNTIME = "llvm"

EXTRA_OECMAKE_append_class-native = " \
    -D BUILD_SHARED_LIBS=OFF \
    -D FILAMENT_SUPPORTS_VULKAN=ON \
    -D FILAMENT_SUPPORTS_OPENGL=OFF \
    -D FILAMENT_SUPPORTS_WAYLAND=ON \
    -D FILAMENT_SKIP_SAMPLES=ON \
    -D CMAKE_VERBOSE_MAKEFILE=ON \
    "

EXTRA_OECMAKE_append_class-target = " \
    -D BUILD_SHARED_LIBS=OFF \
    -D FILAMENT_SUPPORTS_VULKAN=ON \
    -D FILAMENT_SUPPORTS_OPENGL=OFF \
    -D FILAMENT_SUPPORTS_WAYLAND=ON \
    -D FILAMENT_SKIP_SAMPLES=ON \
    -D CMAKE_VERBOSE_MAKEFILE=ON \
    "

# FILES_${PN} = " \
#    ${libdir}/* \
#    "

# FILES_${PN}-dev  = " \
#    ${includedir}/* \
#    ${libdir}/pkgconfig/* \
#    "

# FILES_SOLIBSDEV = ""
# INSANE_SKIP_${PN} += "dev-so"

BBCLASSEXTEND += "native nativesdk"
