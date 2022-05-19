job('example') {
    configure { project ->
        project / builders / 'hudson.tasks.Shell' {
            command 'echo "Hello" > ${WORKSPACE}/out.txt'
        }
    }
}
