import log from './logger.js';
import extractPlistEntry from './extract';


async function extractBundleId (app) {
  log.debug("Getting bundle ID from app");
  return await extractPlistEntry(app, 'CFBundleIdentifier');
}


export default extractBundleId;
