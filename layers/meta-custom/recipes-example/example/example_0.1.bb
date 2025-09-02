SUMMARY = "A simple example recipe"
DESCRIPTION = "This recipe installs a simple shell script that prints a message."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# No source files needed, the script is created within the recipe.
SRC_URI = ""

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    # Create the shell script
    echo "#!/bin/sh" > ${D}${bindir}/example-hello
    echo "echo 'Hello from meta-custom!'" >> ${D}${bindir}/example-hello
    # Make it executable
    chmod 0755 ${D}${bindir}/example-hello
}

# Ensure the script is included in the package.
FILES:${PN} += "${bindir}/example-hello"
