export default async function globalTeardown() {
    await global.MONGOINSTANCE.stop()
}