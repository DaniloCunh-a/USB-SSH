#!/bin/sh
#
# Start the network....
#

# Inicia a OTG-USB - ETHER
mkdir -p /run/network
echo none > /sys/class/leds/Heartbeat/trigger
echo 1 > /sys/class/leds/Heartbeat/brightness

generate_random_mac() {
    # Gera um MAC aleatório com o bit local administrado (bit 2 do primeiro byte é 1)
    printf '02:%02x:%02x:%02x:%02x:%02x\n' $((RANDOM % 256)) $((RANDOM % 256)) $((RANDOM % 256)) $((RANDOM % 256)) $((RANDOM % 256))
}
    # Gera um endereço IP aleatório na faixa 192.168.44.xx
generate_random_ip() {
    printf "192.168.44.%d\n" $((RANDOM % 240 + 1))  # Gera IP entre 192.168.44.1 e 192.168.44.240
}
case "$1" in
  start)
        #modprobe g_serial
        #setsid getty -L -l /bin/sh -n 115200 /dev/ttyGS0
        #modprobe g_ether

        # Gera o MAC aleatóri
        RANDOM_MAC=$(generate_random_mac)
        RANDOM_IP=$(generate_random_ip)

        # Configura o MAC e inicia a interface com IP dinâmico
        ifconfig usb0 down
        ip link set usb0 address "$RANDOM_MAC"
        ifconfig usb0 "$RANDOM_IP" netmask 255.255.255.0
        ifconfig usb0 up

        echo "Interface usb0 configurada com MAC $RANDOM_MAC e IP $RANDOM_IP."



        ;;
  stop)
        printf "Stopping..."

#TODO
        ;;
  restart|reload)
        "$0" stop
        "$0" start
        ;;
  *)
        echo "Usage: $0 {start|stop|restart}"
        exit 1
esac

exit $?